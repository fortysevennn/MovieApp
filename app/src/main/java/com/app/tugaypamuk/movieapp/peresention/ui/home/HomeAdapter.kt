package com.app.tugaypamuk.movieapp.peresention.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.tugaypamuk.movieapp.R
import com.app.tugaypamuk.movieapp.databinding.RowMovieBinding
import com.app.tugaypamuk.movieapp.domain.model.MovieSearch

class HomeAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    class HomeViewHolder(var view : RowMovieBinding) : RecyclerView.ViewHolder(view.root)


    private val diffUtil = object : DiffUtil.ItemCallback<MovieSearch>(){
        override fun areContentsTheSame(oldItem: MovieSearch, newItem: MovieSearch): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: MovieSearch, newItem: MovieSearch): Boolean {
            return oldItem == newItem
        }
    }
    private val listDiffer = AsyncListDiffer(this,diffUtil)
    var list2 : List<MovieSearch>
    get() = listDiffer.currentList
    set(value) = listDiffer.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RowMovieBinding>(
            inflater,
            R.layout.row_movie,
            parent,
            false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.view.items = list2[position]
        holder.itemView.setOnClickListener {
            listener.onSearchItemClicked(list2[position].imdbID)
        }
    }

    override fun getItemCount(): Int {
        return list2.size
    }

    interface OnItemClickListener{
        fun onSearchItemClicked(movieId : String)
    }

}