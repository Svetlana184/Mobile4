package com.example.mobile4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile4.databinding.FragmentEventsBinding
import retrofit2.Call
import retrofit2.Response



class EventsFragment : Fragment() {
    private lateinit var binding: FragmentEventsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentEventsBinding.inflate(inflater, container, false)
        var apiInterface:NewEventsApi=RetrofitHelper.getInstance().create(NewEventsApi::class.java)
        var adapter=EventsAdapter()

        apiInterface.getUnis().enqueue(object: retrofit2.Callback<ArrayList<Country>> {
            override fun onResponse(p0: Call<ArrayList<Country>>, p1: Response<ArrayList<Country>>) {

                adapter.events=p1.body()!!
                binding.rvEvents.layoutManager=LinearLayoutManager(context)
                binding.rvEvents.adapter=adapter

            }
            override fun onFailure(p0: Call<ArrayList<Country>>, p1: Throwable) {
                Log.d("error",p1.message.toString())
            }
        })
        return binding.root
    }
}