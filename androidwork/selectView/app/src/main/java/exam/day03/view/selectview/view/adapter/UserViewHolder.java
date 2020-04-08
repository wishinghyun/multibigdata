package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

//모든 뷰에 대해서 findViewById를 최소화하기 위해 정의
public class UserViewHolder {
    ImageView myImg;
    TextView nameView;
    TextView telNumView;
    EditText editView;

    //객체가 생성될때 targetView(parentView)를 전달받는다
    public UserViewHolder(View parentView) {
        this.myImg = parentView.findViewById(R.id.img);
        this.nameView = parentView.findViewById(R.id.txtcust1);
        this.telNumView = parentView.findViewById(R.id.txtcust2);
        this.editView = parentView.findViewById(R.id.edtinfo);
    }
}
