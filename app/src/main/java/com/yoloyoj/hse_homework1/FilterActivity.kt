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

class FilterActivity : AppCompatActivity() {
    private var filter = emptyList<Int>()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBooleanArray(
            "saved_checks",
            (checkbox_list.adapter as FilterRecycleAdapter)
                .items.map { it.value }.toBooleanArray()
        )
        outState.putIntArray(
            "nowFilter",
            filter.toIntArray()
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val toFilter = intent.getFloatArrayExtra("toFilter")!!

        var savedChecks = savedInstanceState.getBooleanArray("saved_checks")
        if (savedChecks == null)
            savedChecks = List(toFilter.size) { true }.toBooleanArray()

        filter = savedInstanceState.getIntArray("nowFilter")!!.toList()

        val adapter =
            FilterRecycleAdapter(
                toFilter
                    .mapIndexed { index, fl ->
                        FilterItem(fl, savedChecks[index])
                    }
            )

        checkbox_list.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val toFilter = intent.getFloatArrayExtra("toFilter")!!
        val nowFilter = intent.getBooleanArrayExtra("nowFilter")!!
        filter = toFilter.filterIndexed { index, _ -> nowFilter[index] }.map { it.toInt() }

        val adapter =
            FilterRecycleAdapter(
                toFilter
                    .mapIndexed { index, item ->
                        FilterItem(item, value = nowFilter[index])
                    }
            )

        checkbox_list.layoutManager = LinearLayoutManager(this)

        checkbox_list.adapter = adapter
    }

    override fun onStart() {
        all_check.setOnCheckedChangeListener { _, b ->
            val adapter =
                FilterRecycleAdapter(
                    (checkbox_list.adapter as FilterRecycleAdapter).items
                        .map { item ->
                            FilterItem(item.exp, value = b)
                        }
                )

            checkbox_list.adapter = adapter
        }

        super.onStart()
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
            "filter",
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
