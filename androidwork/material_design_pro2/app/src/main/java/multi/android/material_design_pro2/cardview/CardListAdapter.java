package multi.android.material_design_pro2.cardview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import multi.android.material_design_pro2.R;
import multi.android.material_design_pro2.recycler.SimpleItem;

//RecyclerView에서 사용하는 Adapter를 커스트마이징
//Adapter안에 ViewHolder가 포함 - 정의 (ListView사용할때와 동일한 역할)
//           -----------
//           Inner Class로 정의
public class CardListAdapter
        extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {
    Context context;
    int row_res_id; //row를 구성하는 layout
    List<CardImgTxtItem> data; //RecyclerView에 출력될 전체 데이터

    public CardListAdapter(Context context, int row_res_id, List<CardImgTxtItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }
    //xml로부터 뷰(한 row에 대한 뷰)를 만들어서 ViewHolder 넘기는 작업
    //View를 구성하는 구성요소의 리소스를 가져오는 작업을 하는 객체
    //1. onCreateViewHolder에서 row에 대한 뷰를 inflate해서 생성
    //2. viewHolder객체를 만들어서 1번에서 생성한 뷰를 넘긴다
    //3. ViewHolder객체 안에서 onCreateViewHolder메소드에서 리턴받은 객체에서 데이터를 연결할 뷰를 찾아온다
    //4. ViewHolder가 갖고 있는 구성요소에 데이터를 연결하기


    //1,2
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //레이아웃 받아오는 방법들은 시스템, 겟레이아웃, from
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new ViewHolder(view); //만들어서 새로 만든 뷰 홀더를 넘긴다
    }

    //4
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("recycler","onBindViewHolder"+position);
        ImageView cardimg = holder.imgview;
        TextView cardtxt = holder.txtview;
        cardimg.setImageResource(data.get(position).getImg());
        cardtxt.setText(data.get(position).getTxt());
    }

    //RecyclerView에 출력할 데이터의 갯수리턴
    @Override
    public int getItemCount() {
        return data.size();
    }

    //3
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgview;
        TextView txtview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.cardimg);
            txtview = itemView.findViewById(R.id.cardtxt);
        }
    }
}
