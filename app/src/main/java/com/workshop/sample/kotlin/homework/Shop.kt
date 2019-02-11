package com.workshop.sample.kotlin.homework

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class Order(val products: List<Product>, val isDelivered: Boolean){
    fun totalprice():Double{
        var sum:Double=0.0
        for (i in products)
            sum+=i.price
        return sum
    }
}

data class Product(val name: String, val price: Double)

data class City(val name: String)
