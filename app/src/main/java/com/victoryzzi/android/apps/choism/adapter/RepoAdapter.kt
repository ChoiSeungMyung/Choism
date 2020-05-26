package com.victoryzzi.android.apps.choism.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.victoryzzi.android.apps.choism.R
import com.victoryzzi.android.apps.choism.adapter.viewholder.RepoViewHolder
import com.victoryzzi.android.apps.choism.model.GithubRepo

class RepoAdapter : ListAdapter<GithubRepo, RepoViewHolder>(RepoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_repo,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class RepoDiffCallback : DiffUtil.ItemCallback<GithubRepo>() {
    override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean =
        oldItem.repoName == newItem.repoName
}