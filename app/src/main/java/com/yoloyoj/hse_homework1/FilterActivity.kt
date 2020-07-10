package com.yoloyoj.hse_homework1

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoloyoj.hse_homework1.filter_recycler_adapter.FilterRecycleAdapter
import com.yoloyoj.hse_homework1.filter_recycler_adapter.models.FilterItem
import kotlinx.android.synthetic.main.activity_filter.*

const val SAVED_CHECKING = "saved_checks"
const val CURRENT_FILTER = "nowFilter" // filter state before go to here
const val YEARS_TO_FILTER = "toFilter" // skill values
const val FILTER_STATES = "filter"

class FilterActivity : AppCompatActivity() {
    private var filter = emptyList<Int>()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBooleanArray(
            SAVED_CHECKING,
            (checkbox_list.adapter as FilterRecycleAdapter)
                .items.map { it.value }.toBooleanArray()
        )

        outState.putIntArray(
            CURRENT_FILTER,
            filter.toIntArray()
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val yearsToFilter = intent.getFloatArrayExtra(YEARS_TO_FILTER)!!

        var savedChecks = savedInstanceState.getBooleanArray(SAVED_CHECKING)
        if (savedChecks == null)
            savedChecks = List(yearsToFilter.size) { true }.toBooleanArray()

        filter = savedInstanceState.getIntArray(CURRENT_FILTER)!!.toList()

        loadAdapter(
            yearsToFilter.asList().product(savedChecks.asList()).map {
                FilterItem(it.first, it.second)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        checkbox_list.layoutManager = LinearLayoutManager(this)

        loadExtras()
    }

    override fun onStart() {
        all_check.setOnCheckedChangeListener { _, b ->
            loadAdapter((checkbox_list.adapter as FilterRecycleAdapter).items
                .map { item -> FilterItem(item.exp, value = b) }
            )
        }

        super.onStart()
    }

    private fun loadExtras() {
        val yearsToFilter = intent.getFloatArrayExtra(YEARS_TO_FILTER)!!.toList()
        val receivedFilterStates = intent.getBooleanArrayExtra(CURRENT_FILTER)!!.toList()

        filter = yearsToFilter.filterBy(receivedFilterStates).map { it.toInt() }

        loadAdapter(
            yearsToFilter.product(receivedFilterStates).map {
                FilterItem(it.first, it.second)
            }
        )
    }

    private fun loadAdapter(items: List<FilterItem>) {
        val adapter = FilterRecycleAdapter(items)

        checkbox_list.adapter = adapter
    }

    @Suppress("UNUSED_PARAMETER")
    fun onFiltersChosen(view: View) {
        sendResult(
            (checkbox_list.adapter as FilterRecycleAdapter)
                .items.filter { it.value }.map { it.exp.toInt() }.toIntArray()
        )
    }

    override fun onBackPressed() {
        sendResult(filter.toIntArray())
    }

    private fun sendResult(result: IntArray) {
        val answerIntent = Intent()

        answerIntent.putExtra(
            FILTER_STATES,
            result
        )

        setResult(0, answerIntent)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
