package com.example.viewpager2fragments

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2fragments.apptray.TestFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val l: Lifecycle = lifecycle
        viewPager = view_pager
        viewPager.adapter = TestFragmentAdapter(supportFragmentManager, l)


/*        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return CardFragment.create(Card.DECK[position])
            }

            override fun getItemCount(): Int {
                return Card.DECK.size
            }
        }
    }

    class CardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val cardView = CardView(layoutInflater, container)
            cardView.bind(Card.fromBundle(arguments!!))
            return cardView.view
        }

        companion object {

            */
        /** Creates a Fragment for a given [Card]  *//*
            fun create(card: Card): CardFragment {
                val fragment = CardFragment()
                fragment.arguments = card.toBundle()
                return fragment
            }
        }
    }*/
    }
}
