package com.example.exam

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FirebaseRepo {

    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()



    fun getOrdersList(): Task<QuerySnapshot> {
        return firebaseFirestore
            .collection("orders")
            .get()
    }

}