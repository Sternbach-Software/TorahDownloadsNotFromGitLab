package tech.torah.aldis.androidapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l4digital.fastscroll.FastScrollRecyclerView
import com.l4digital.fastscroll.FastScroller

private const val TAG = "BrowseActivity"

class BrowseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"RAN SUCCESSFULL!")
        setContentView(R.layout.speaker_page_recycler_view_layout)

        val recyclerView: FastScrollRecyclerView? = findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.adapter = SpeakerAdapter(mutableListOf(
            Speaker(),
            Speaker(),
            Speaker(),
            Speaker(),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Helfgot"),
            Speaker(last_name="Melbourne"),
            Speaker(last_name="Pransky"),
            Speaker(last_name="Zelig")
        )
        )
    }
}

class SpeakerAdapter(val speakerList: MutableList<Speaker>) :
    RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>(), FastScroller.SectionIndexer {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpeakerViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.individual_speaker_card_layout, parent, false)
        return SpeakerViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        holder.bindItems(speakerList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return speakerList.size
    }

    override fun getSectionText(position: Int): CharSequence {
        return speakerList[position].last_name.first().toString()
        //TODO not sure if I implemented this right.
    }

    //the class is hodling the list view
    class SpeakerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(speaker: Speaker) {
            val speakerName = itemView.findViewById(R.id.speaker_name) as TextView?
            val speakerDescription = itemView.findViewById(R.id.speaker_description) as TextView?
            if (speakerName != null) {
                speakerName.text = speaker.name
                Log.d(TAG,"Run")
            }
            if (speakerDescription != null) {
                speakerDescription.text = speaker.description
            }
            (itemView.findViewById(R.id.speaker_image) as ImageView?)?.setImageResource(R.drawable.rabbi_yisroel_belsky)
        }
    }
}