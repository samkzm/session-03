package com.workshop.sample.kotlin.homework


fun main(){

    val city_1=City("Tehran")
    val city_2=City("Shiraz")
    val prod_1=Product("shampu",12.5)
    val prod_2=Product("mast",22.5)
    val prod_3=Product("chips",10.5)
    val prolist_1= listOf<Product>(prod_1,prod_3)
    val prolist_2= listOf<Product>(prod_1,prod_2,prod_3)
    val order_1=Order(prolist_1,true)
    val order_2=Order(prolist_2,true)
    val orderlist_1= listOf<Order>(order_1)
    val orderlist_2= listOf<Order>(order_2)
    val orderlist_3= listOf<Order>(order_1,order_2)
    val cust_1=Customer("mohsen",city_1,orderlist_1)
    val cust_2=Customer("hamid",city_2,orderlist_3)
    val cust_3=Customer("samane",city_1,orderlist_2)
    val cust= listOf<Customer>(cust_1,cust_2,cust_3)
    val shop1=Shop("hyper",cust)
    fun max(list: List<Int>): Int? {
        if (list!=null) {
            var max1 = list[0]
            var maxindex = 0
            for (i in list.indices)
                if (list[i] > max1) {
                    max1 = list[i]
                    maxindex = i
                }
            return maxindex
        }
        return null
    }

    fun find(list: List<String>, what: City): Int {
        for (i in list.indices)
            if (what.name==list[i])
                return i

        return -1
    }

    fun getCityThatMostCustomersAreFrom(shop:Shop): City? {
    if (shop.customers.size!=0) {
        var myList: MutableList<Int> = mutableListOf<Int>()
        var name = listOf<String>()
        var j = 0
        for (i in shop.customers) {
            var k = find(name, i.city)
            if (k != -1) {
                myList[k] += 1
            } else {
                name += i.city.name
                myList.add(1)
                j += 1
            }
        }
        val m = max(myList)
        for (i in shop.customers)
            if (m!=null && i.city.name == name[m])
                return i.city
    }
    return null
}
    println(getCityThatMostCustomersAreFrom(shop1))

fun getCustomerWithMaximumNumberOfOrders(shop:Shop): Customer? {
    if(shop.customers.size!= 0) {
        var sum: Double = 0.0
        var max = 0.0
        var maxcust = 0
        for (i in shop.customers.indices) {
            sum = 0.0
            for (j in shop.customers[i].orders)
                sum += j.totalprice()
            if (sum > max) {
                max = sum
                maxcust = i
            }
        }
        if(max!=0.0)
            return shop.customers[maxcust]
    }
    return null
}
    println(getCustomerWithMaximumNumberOfOrders(shop1))
}
