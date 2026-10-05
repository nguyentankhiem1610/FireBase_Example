package vn.edu.ueh.thanhdnh.firebase_example;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView txtTitle, txtContent, txtView;
    private ImageView imgCover;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.txtDetailTitle);
        txtContent = findViewById(R.id.txtDetailContent);
        txtView = findViewById(R.id.txtDetailView);
        imgCover = findViewById(R.id.imgDetailCover);
        btnBack = findViewById(R.id.btnBackDetail);

        // Nút Back đóng Activity
        btnBack.setOnClickListener(v -> finish());

        Article article = (Article) getIntent()
                .getSerializableExtra("article_item");

        if (article != null) {
            // Hiển thị chữ
            txtTitle.setText(article.getTitle());
            txtContent.setText(article.getContent());
            txtView.setText("Views: " + article.getView());

            // Hiển thị ảnh
            String url = article.getImg_cover();

            Picasso.get()
                    .load(url == null || url.trim().isEmpty()
                            ? null : url.trim())
                    .placeholder(android.R.drawable.ic_menu_gallery)
                    .error(android.R.drawable.ic_menu_gallery)
                    .into(imgCover);
        }
    }
}