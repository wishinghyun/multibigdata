package multi.android.permissiontestpro;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;//view에 대한 리소스
    private ArrayList<ActorItem> data;//핸들링할 데이터
    private HashMap<Integer,MyMemento> userStateValue = new HashMap<Integer,MyMemento>();
    int value;
    public ExamAdapter(Context context,
                     int textViewResourceId,	ArrayList<ActorItem> objects) {

        super(context, textViewResourceId, objects);
        Log.d("constructor","생성자호출");
        this.context = context;
        this.resId = textViewResourceId;
        this.data = objects;
        Log.d("constructor",data.size()+"");
    }




    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if(convertView==null){
            value++;
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId,null);
            ViewHolder itemView = new ViewHolder(convertView);
            convertView.setTag(itemView);
            convertView.setTag(R.string.app_name,value);
            Log.d("firstjob","최초작업"+data.get(position).name
                    +",,,,,,,targetView:"+convertView);
        }
        ViewHolder itemView = (ViewHolder)convertView.getTag();
        ActorItem actorItem = data.get(position);
        Log.d("getview",actorItem.toString()+"====================="+
                convertView.getTag(R.string.app_name));
        if(actorItem!=null) {
            ImageView myimg = itemView.myimg;
            final TextView nameView = itemView.nameView;
            TextView dateView = itemView.dateView;
            TextView info = itemView.info;
            final CheckBox chkVal = itemView.chkVal;
            myimg.setImageResource(actorItem.myImg);
            nameView.setText(actorItem.name);
            dateView.setText(actorItem.date);
            info.setText(actorItem.info);
            MyMemento state = userStateValue.get(position);
            if(state ==null){
                //한 번도 저장한 적이 없는 경우
                Log.d("check","널"+position);
                chkVal.setChecked(false);
            }else{
                Log.d("check","널아님"+position);
                chkVal.setChecked(state.check);
            }
            Log.d("getview",nameView.getText().toString()+","+dateView.getText().toString()+
                    "****************targetView:"+convertView);
            chkVal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d("onCheckedChanged",isChecked+":"+position);
                    boolean data = chkVal.isChecked();
                    MyMemento state = new MyMemento();
                    state.check = data;
                    userStateValue.put(position,state);
                }
            });



        }
        return  convertView;
    }

    class MyMemento{
        boolean check;
    }

    class ViewHolder{
        ImageView myimg;
        TextView nameView;
        TextView dateView;
        TextView info;
        CheckBox chkVal;
        ViewHolder(View parentView){
            Log.d("viewholder","ViewHolder호출");
            this.myimg = parentView.findViewById(R.id.myImg);
            this.nameView = parentView.findViewById(R.id.name);
            this.dateView = parentView.findViewById(R.id.date);
            this.info = parentView.findViewById(R.id.resultinfo);
            this.chkVal = parentView.findViewById(R.id.exam_check);
        }
    }
}

