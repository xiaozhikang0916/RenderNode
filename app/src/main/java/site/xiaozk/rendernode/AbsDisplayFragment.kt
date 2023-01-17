package site.xiaozk.rendernode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import site.xiaozk.rendernode.R

/**
 * @author: xiaozhikang
 * @mail: xiaozhikang0916@gmail.com
 * @create: 2023/1/6
 */
abstract class AbsDisplayFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.list).run {
            adapter = object : ListAdapter<Int, ViewHolder>(object : ItemCallback<Int>() {
                override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
                    return oldItem == newItem
                }
            }) {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                    return object : ViewHolder(inflateItemView(parent)) {}
                }

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {

                }

            }.also {
                it.submitList((0..50).toList())
            }
        }
    }

    abstract fun inflateItemView(parent: ViewGroup): View
}