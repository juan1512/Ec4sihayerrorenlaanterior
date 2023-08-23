package com.juan.equipoec4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juan.equipoec4.databinding.ItemEquipoBinding
import com.juan.equipoec4.model.Equipo

class RVListAdapter(var equipos: List<Equipo>, val onClick: (Equipo) -> Unit):RecyclerView.Adapter<EquipoVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipoVH {
        val binding = ItemEquipoBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return EquipoVH(binding, onClick)
    }

    override fun getItemCount(): Int = equipos.size


    override fun onBindViewHolder(holder: EquipoVH, position: Int) {
        holder.bind(equipos[position])
    }
}

class EquipoVH(private var binding: ItemEquipoBinding, val onClick: (Equipo) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun bind(equipo: Equipo) {

        binding.txtGender.text = equipo.gender
        binding.txtName.text = equipo.name
        binding.txtShortCode.text = equipo.short_code
        binding.txtFounded.text = equipo.founded
        binding.txtType.text = equipo.type
        binding.txtPlaceholder.text = equipo.placeholder
        binding.txtLastPlayedAt.text = equipo.last_played_at
        Glide.with(binding.root)
            .load(equipo.image_path)
            .into(binding.imageView)
        binding.root.setOnClickListener {
            onClick(equipo)
        }
    }
}