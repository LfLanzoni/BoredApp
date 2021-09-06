package ar.android.lflanzoni.boredapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ar.android.lflanzoni.boredapp.R

class AdapterCategories(private val categories: List<String>): RecyclerView.Adapter<AdapterCategories.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.btnCategory)

        init {
            button.setOnClickListener {
                view.findNavController().navigate(R.id.action_boredCategoriesFragment_to_boredActivityFragment)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.button.text = categories[position]
    }

    override fun getItemCount() = categories.size
}