package com.example.mobile4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        apiInterface.getEvents().enqueue(object: retrofit2.Callback<ArrayList<Events>> {
            override fun onResponse(p0: Call<ArrayList<Events>>, p1: Response<ArrayList<Events>>) {
                var adapter=EventsAdapter()
                adapter.events=p1.body()!!
                binding.rvEvents.adapter=adapter
            }
            override fun onFailure(p0: Call<ArrayList<Events>>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return binding.root
    }
}