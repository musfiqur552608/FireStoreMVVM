package org.freedu.firestoremvvm

import com.google.firebase.firestore.FirebaseFirestore
import org.freedu.firestoremvvm.model.Student

class FireStoreHelper {
    private val db = FirebaseFirestore.getInstance()
    fun addStudent(student: Student) {
        db.collection("students")
            .add(student)
    }
    fun getStudents(callback: (List<Student>) -> Unit) {
        db.collection("students")
            .get()
            .addOnSuccessListener {
                val students = it.map {
                    it.toObject(Student::class.java)
                }
                callback(students)
            }
    }
    fun updateStudent(studentId: String, newData: Map<String, Any>) {
        db.collection("students")
            .document(studentId)
            .update(newData)
    }
    fun deleteStudent(studentId: String) {
        db.collection("students")
            .document(studentId)
            .delete()
    }
}