package com.example.myapplication.ViewHolder//package com.example.myapplication.ViewHolder
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.myapplication.Model.ProductResponse
//import com.example.myapplication.Repository.Repository
//import kotlinx.coroutines.launch
//import retrofit2.Response
//
//class ProductCardViewHolder(private val repository: Repository):ViewModel() {
//
//     val productResponse : MutableLiveData<Response<ProductResponse>> = MutableLiveData()
//
//    fun getProductList(size: Int , page : Int){
//        viewModelScope.launch {
//            val response = repository.getProduct(5, 0)
//            productResponse.value = response
//        }
//    }
//}