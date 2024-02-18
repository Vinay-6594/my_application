package com.example.myapplication

import android.R
import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme


class ComponentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
        val listView = findViewById<ListView>(R.id.list_container)
        listView.adapter = CustomAdapter()
        listView.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                // Handle item click here
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true
    }

    private inner class CustomAdapter : BaseAdapter() {
        private val items = arrayOf(
            "Hi community! I am open to new connections",
            "Ganesh Yelagandula",
            "Sandeep Kumar Adepu"
        )
        private val subItems = arrayOf("", "Hyderabad | Student", "Hyderabad | Student")
        private val distances = arrayOf("", "Within 700-800 m", "Within 200-300 m")
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(position: Int): Any {
            return items[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
            var view = convertView
            if (view == null) {
                view = layoutInflater.inflate(R.layout.list_content, null)
            }
            val titleTextView = view.findViewById<TextView>(R.id.title)
            val subTitleTextView = view.findViewById<TextView>(R.id.title)
            val distanceTextView = view.findViewById<TextView>(R.id.icon1)
            val imageView = view.findViewById<ImageView>(R.id.icon2)
            titleTextView.text = items[position]
            subTitleTextView.text = subItems[position]
            distanceTextView.text = distances[position]
            when (position) {
                0 -> imageView.setImageResource(R.drawable.star_on)
                1 -> imageView.setImageResource(R.drawable.presence_away)
                2 -> imageView.setImageResource(R.drawable.presence_away)
            }
            return view
        }
    }
}
