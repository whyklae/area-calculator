package com.inafianti.areacalculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.inafianti.areacalculator.ui.theme.SquareAreaTheme

class MainActivity : AppCompatActivity() {

    private lateinit var sisi: EditText
    private lateinit var sisi1: EditText
    private lateinit var sisi2: EditText
    private lateinit var alas: EditText
    private lateinit var tinggi: EditText
    private lateinit var jari_jari: EditText
    private lateinit var diagonal1: EditText
    private lateinit var diagonal2: EditText
    private lateinit var luas: EditText
    private lateinit var spinner: Spinner
    private lateinit var buttonLuas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bangunDatar = resources.getStringArray(R.array.bangun_datar_arrays)

        spinner = findViewById(R.id.bangundatar_spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, bangunDatar)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    when(position) {
                        1 -> {
                            setContentView(R.layout.square_area_form)
                            sisi = findViewById(R.id.sisi_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateSquareArea()
                            }
                        }
                        2 -> {
                            setContentView(R.layout.rectangle_area_form)
                            sisi1 = findViewById(R.id.sisi1_edit)
                            sisi2 = findViewById(R.id.sisi2_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateRectangleArea()
                            }
                        }
                        3 -> {
                            setContentView(R.layout.triangle_area_form)
                            alas = findViewById(R.id.alas_edit)
                            tinggi = findViewById(R.id.tinggi_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateTriangleArea()
                            }
                        }
                        4 -> {
                            setContentView(R.layout.circle_area_form)
                            jari_jari = findViewById(R.id.jari_jari_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateCircleArea()
                            }
                        }
                        5 -> {
                            setContentView(R.layout.parallelogram_area_form)
                            alas = findViewById(R.id.alas_edit)
                            tinggi = findViewById(R.id.tinggi_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateParallelogramArea()
                            }
                        }
                        6 -> {
                            setContentView(R.layout.trapezoid_area_form)
                            sisi1 = findViewById(R.id.sisi1_edit)
                            sisi2 = findViewById(R.id.sisi2_edit)
                            tinggi = findViewById(R.id.tinggi_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateTrapezoidArea()
                            }
                        }
                        7 -> {
                            setContentView(R.layout.rhombus_area_form)
                            diagonal1 = findViewById(R.id.diagonal1_edit)
                            diagonal2 = findViewById(R.id.diagonal2_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateRhombusArea()
                            }
                        }
                        8 -> {
                            setContentView(R.layout.rhombus_area_form)
                            diagonal1 = findViewById(R.id.diagonal1_edit)
                            diagonal2 = findViewById(R.id.diagonal2_edit)
                            luas = findViewById(R.id.luas_edit)
                            buttonLuas = findViewById(R.id.luas_button)

                            buttonLuas.setOnClickListener {
                                calculateKiteArea()
                            }
                        }
                    }

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
                }
        }
    }

    fun calculateSquareArea() {
        val side = sisi.text.toString().toDouble()
        val squareArea = side * side
        return luas.setText(squareArea.toString())
    }

    fun calculateRectangleArea() {
        val side1 = sisi1.text.toString().toDouble()
        val side2 = sisi2.text.toString().toDouble()
        val rectangleArea = side1 * side2
        return luas.setText(rectangleArea.toString())
    }

    fun calculateTriangleArea() {
        val base = alas.text.toString().toDouble()
        val height = tinggi.text.toString().toDouble()
        val triangleArea = 0.5 * base * height
        return luas.setText(triangleArea.toString())
    }

    fun calculateCircleArea() {
        val radius = jari_jari.text.toString().toDouble()
        val phi = 3.14
        val circleArea = phi * radius * radius
        return luas.setText(circleArea.toString())
    }

    fun calculateParallelogramArea() {
        val base = alas.text.toString().toDouble()
        val height = tinggi.text.toString().toDouble()
        val parallelogramArea = base * height
        return luas.setText(parallelogramArea.toString())
    }

    fun calculateTrapezoidArea() {
        val side1 = sisi1.text.toString().toDouble()
        val side2 = sisi2.text.toString().toDouble()
        val height = tinggi.text.toString().toDouble()
        val trapezoidArea = 0.5 * (side1 + side2) * height
        return luas.setText(trapezoidArea.toString())
    }

    fun calculateRhombusArea() {
        val diag1 = diagonal1.text.toString().toDouble()
        val diag2 = diagonal2.text.toString().toDouble()
        val rhombusArea = 0.5 * diag1 * diag2
        return luas.setText(rhombusArea.toString())
    }

    fun calculateKiteArea() {
        val diag1 = diagonal1.text.toString().toDouble()
        val diag2 = diagonal2.text.toString().toDouble()
        val kiteArea = 0.5 * diag1 * diag2
        return luas.setText(kiteArea.toString())
    }
}