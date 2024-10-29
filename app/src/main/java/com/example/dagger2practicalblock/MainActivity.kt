package com.example.dagger2practicalblock

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**Сделать многомодульный проект в котором есть 3 модуля. Каждый модуль имеет свой компонент.
- app
- core
- feature.home
В core есть 2 объекта ретрофита. 1 смотрит на первый сервер, другой на второй. В featue.home мы получаем оба объекта и делаем 2 разных запроса.
(Вьюшки не нужны, запросы можно сделать фейковыми, результат получать необязательно, упор тут на DI)
Все это с Clean Architecture
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
