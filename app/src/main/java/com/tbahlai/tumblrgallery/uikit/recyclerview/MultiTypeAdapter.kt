package com.tbahlai.tumblrgallery.uikit.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

typealias HolderPredicate<T> = (item: T) -> Boolean
typealias HolderGenerator<T> = (ViewGroup) -> BaseHolder<out T>


fun interface Initializer<T> {
    operator fun invoke(_this: MultiTypeAdapter<T>)
}


open class MultiTypeAdapter<T> constructor(
    val items: MutableList<T> = mutableListOf(),
) : RecyclerView.Adapter<BaseHolder<T>>() {

    var diffUtilCallback: MultiTypeDiffUtilCallback<T>? = null
    private val viewTypes: MutableMap<HolderPredicate<T>, Int> = mutableMapOf()
    private val holderGenerators: MutableMap<Int, HolderGenerator<T>> = mutableMapOf()

    constructor(items: List<T> = listOf(), generator: HolderGenerator<T>) : this(items.toMutableList()) {
        holder1(generator)
    }

    override fun getItemViewType(position: Int): Int {
        try {
            return viewTypes.filterKeys { it(items[position]) }.values.first()
        } catch (e: Throwable) {
            throw RuntimeException("'${javaClass.simpleName}' has no holder for type '${items[position]}'", e)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder<T> {
        @Suppress("UNCHECKED_CAST")
        val holder = holderGenerators[viewType]!!(parent) as BaseHolder<T>

        holder.onCreate()

        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @CallSuper
    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int) {
        holder.bind(itemCount, items[position])
    }

    override fun onBindViewHolder(holder: BaseHolder<T>, position: Int, payloads: List<Any>) {
        if (payloads.isNotEmpty()) {
            holder.updateWithPayloads(position, itemCount, items[position], payloads)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    fun setItems(newItems: List<T>) {
        if (diffUtilCallback != null) {
            diffUtilCallback!!.newList = newItems
            diffUtilCallback!!.oldList = items
            val diffUtilResult = DiffUtil.calculateDiff(diffUtilCallback!!)
            diffUtilResult.dispatchUpdatesTo(this)
            items.clear()
            items += newItems
        } else {
            items.clear()
            items += newItems
            notifyDataSetChanged()
        }
    }

    open operator fun get(position: Int): T {
        return items[position]
    }

    open operator fun set(position: Int, newItem: T) {
        items[position] = newItem
        notifyItemChanged(position)
    }

    fun holder1(generator: HolderGenerator<T>) {
        holder {
            this.viewType = 0
            this.predicate = { true }
            this.generator = generator
        }
    }

    fun holder(block: HolderDefinition<T>.() -> Unit): MultiTypeAdapter<T> {
        val hd = HolderDefinition<T>().apply(block)
        viewTypes[hd.predicate] = hd.viewType
        holderGenerators[hd.viewType] = hd.generator
        return this
    }

}


abstract class BaseHolder<T> : RecyclerView.ViewHolder {

    val context: Context
        get() = itemView.context

    constructor(v: View) : super(v)

    constructor(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup
    ) : super(LayoutInflater.from(parent.context).inflate(layoutRes, parent, false))

    open fun onCreate() {
    }

    open fun bind(item: T) {
    }

    open fun bind(itemCount: Int, item: T) {
        bind(item)
    }

    open fun updateWithPayloads(pos: Int, itemCount: Int, item: T, payloads: List<Any>) {
    }

}


class HolderDefinition<T> internal constructor() {

    var viewType: Int = -1
    lateinit var predicate: HolderPredicate<T>
    lateinit var generator: HolderGenerator<T>

}
