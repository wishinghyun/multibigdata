package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resIdE;
    private List<ActorItem> datalistE;
    HashMap<Integer, SaveActorState> savechk = new HashMap<Integer, SaveActorState>();
    public ExamAdapter(Context context, int resIdE, List<ActorItem> datalistE) {
        super(context, resIdE, datalistE);
        this.context = context;
        this.resIdE = resIdE;
        this.datalistE = datalistE;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resIdE, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ActorItem actorItem = datalistE.get(position);
        if(actorItem!=null) {
            ImageView imageView = holder.imgEV;
            TextView nameView = holder.nameEV;
            TextView dateView = holder.dateEV;
            TextView txtView  = holder.txtEV;
            final CheckBox chkView = holder.chkEV;

            imageView.setImageResource(actorItem.imgE);
            nameView.setText(actorItem.nameE);
            dateView.setText(actorItem.dateE);
            txtView.setText(actorItem.txtE);

            final SaveActorState state = savechk.get(position);
            if(state==null){
                chkView.setChecked(false);
            }else {
                chkView.setChecked(true);
            }

            chkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Boolean state1 = chkView.isChecked();
                    SaveActorState chkcheck = new SaveActorState();
                    chkcheck.checkBox= state1;
                    savechk.put(position,chkcheck);
                }
            });


        }
        return convertView;
    }
}
