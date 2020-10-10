package com.example.dailydrama

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.content_main1.*


class NewsAdapter(val context: Context, val artilces: List<Article>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

      val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)

        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
         return artilces.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {


        val article=artilces[position]
        holder.progressbar.visibility=View.VISIBLE
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description
        Glide.with(context).load(article.urlToImage).listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.progressbar.visibility=View.GONE
                    Toasty.warning(context, "unable to load the image at this moment", Toast.LENGTH_SHORT, true).show();
                   return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    holder.progressbar.visibility=View.GONE
                    return false
                }
//listner for checking whether image has loaded or not..
            }). into(holder.newsImage)



        holder.itemView.setOnClickListener{
         Toasty.success(context, article.title, Toast.LENGTH_SHORT,true).show();

            var intent= Intent(context,DetailedActivity::class.java)
            intent.putExtra("URL",article.url)
            context.startActivity(intent)

        }

    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsImage = itemView.findViewById<ImageView>(R.id.news_image)
        var newsTitle = itemView.findViewById<TextView>(R.id.news_title)
        var newsDescription = itemView.findViewById<TextView>(R.id.news_description)
        var progressbar = itemView.findViewById<ProgressBar>(R.id.progressBar_item_layout)


    }

}