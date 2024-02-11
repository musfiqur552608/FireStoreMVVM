package org.freedu.firestoremvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.freedu.firestoremvvm.R
import org.freedu.firestoremvvm.StudentAdaptar
import org.freedu.firestoremvvm.model.Student
import org.freedu.firestoremvvm.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: StudentViewModel by viewModels()
    private lateinit var adapter: StudentAdaptar
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.studentRV)

        adapter = StudentAdaptar(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val sampleStudent = Student("John Doe", "12345", "john.doe@example.com", "A", "123 Street", "1234567890", 20)
        viewModel.addStudent(sampleStudent)

        viewModel.getStudents {
            adapter.studentList = it
            adapter.notifyDataSetChanged()
        }
    }
}