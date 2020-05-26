package com.victoryzzi.android.apps.choism.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.victoryzzi.android.apps.choism.databinding.ListItemRepoBinding
import com.victoryzzi.android.apps.choism.model.GithubRepo

class RepoViewHolder(private val binding: ListItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(githubRepoData: GithubRepo) {
        binding.apply {
            githubRepo = githubRepoData
        }
    }
}