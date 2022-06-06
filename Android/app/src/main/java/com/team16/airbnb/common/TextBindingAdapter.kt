package com.team16.airbnb.common

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.team16.airbnb.R
import com.team16.airbnb.data.model.DayInfo
import com.team16.airbnb.data.model.MyBookData
import java.text.DecimalFormat

@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("dayCheck")
fun setCheckInCheckOutRange(dayView: TextView, item: DayInfo) {
    dayView.text = item.day

    when {

        !item.isPossible -> {
            dayView.setTextColor(Color.parseColor("#828282"))
        }

        item.isChoice && item.isPossible && !item.isChecked -> {
            dayView.apply {
                setTextColor(Color.parseColor("#FFFFFF"))
                background = dayView.context.getDrawable(R.drawable.ic_choice_date)
            }
        }

        // end까지 선택됨
        item.isChoice && item.isPossible && item.isChecked -> {
            when {

                item.isStart -> {
                    dayView.apply {
                        setTextColor(Color.parseColor("#FFFFFF"))
                        background = dayView.context.getDrawable(R.drawable.ic_date_complete_start)
                    }
                }

                item.isEnd -> {
                    dayView.apply {
                        setTextColor(Color.parseColor("#FFFFFF"))
                        background = dayView.context.getDrawable(R.drawable.ic_date_complete_end)
                    }
                }

            }

        }
        // start와 end 사이 날짜
        !item.isChoice && item.isPossible && item.isChecked -> {
            dayView.apply {
                background = dayView.context.getDrawable(R.drawable.ic_date_range)
            }
        }
        item.isPossible && !item.isChoice -> {
            dayView.apply {
                setTextColor(Color.parseColor("#000000"))
                background = null
            }
        }

    }

}

@BindingAdapter("reviewCount")
fun setReviewCount(textView: TextView, count: Int) {
    "(후기 ${count}개)".also { textView.text = it }
}

@BindingAdapter("moneyFormat")
fun setMoneyFormat(textView: TextView, money: Int) {
    val format = DecimalFormat("₩#,###")
    val money = format.format(money.toLong())
    "$money / 박".also { textView.text = it }
}

@BindingAdapter("totalMoneyFormat")
fun setTotalMoneyFormat(textView: TextView, money: Int) {
    val format = DecimalFormat("₩#,###")
    val money = format.format(money.toLong())
    "총액 $money".also { textView.text = it }
}


@BindingAdapter("checkIn", "checkOut")
fun setBookDate(textView: TextView, checkIn: String, checkOut: String) {
    "$checkIn - $checkOut".also { textView.text = it }
}

@BindingAdapter("address")
fun setAddress(textView: TextView, address: MyBookData.Result.Address) {
    "${address.city}, ${address.district}, ${address.region}, ${address.detail}".also {
        textView.text = it
    }
}
