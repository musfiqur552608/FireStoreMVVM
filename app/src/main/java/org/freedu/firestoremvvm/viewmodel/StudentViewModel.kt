package org.freedu.firestoremvvm.viewmodel

import androidx.lifecycle.ViewModel
import org.freedu.firestoremvvm.FireStoreHelper
import org.freedu.firestoremvvm.model.Student

class StudentViewModel : ViewModel(){
    private val firestoreHelper = FireStoreHelper()

    fun addStudent(student: Student){
        firestoreHelper.addStudent(student)
    }
    fun getStudents(callback: (List<Student>) -> Unit){
        firestoreHelper.getStudents(callback)
    }
    fun updateStudent(studentId: String, newData: Map<String, Any>){
        firestoreHelper.updateStudent(studentId, newData)
    }
    fun deleteStudent(studentId: String){
        firestoreHelper.deleteStudent(studentId)
    }
}