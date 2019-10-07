package  ;


import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    
        /*
		JSONObject是用来解析 {}的，JSONArray 是用来解析[{}]的
        */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonTest="{\"a\":\"qq\",\"b\":\"ww\"}";
        try {
            JSONObject jsonObject=new JSONObject(jsonTest);
            Toast.makeText(MainActivity.this,jsonObject.getString("a"), Toast.LENGTH_SHORT).show();
        } catch (JSONException ex) {
            // 异常处理代码
        }

        /*取消注释即可进行测试
        String jsonTest="[{\"id\":\"10\",\"date\":\"2017-09-07\"},{\"id\":\"9\",\"date\":\"2017-09-04\"}]";
        try {
            JSONArray jsonArray=new JSONArray(jsonTest);
            JSONObject jsonObject=jsonArray.getJSONObject(1);
            Toast.makeText(MainActivity.this,jsonObject.getString("id"), Toast.LENGTH_SHORT).show();
        } catch (JSONException ex) {
            // 异常处理代码
        }
        */
        /*
        String json ="{\"people\": [{\"firstName\": \"Brett\", \"lastName\":\"McLaughlin\"},{ \"firstName\": \"Json\", \"lastName\":\"Hunter\"}],\n" +
                    "\"people2\": [{\"firstName\": \"Brett2\", \"lastName\":\"McLaughli2\"},{ \"firstName\": \"Json3\", \"lastName\":\"Hunter3\"}]}";
        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=jsonObject.getJSONArray("people");
            JSONObject jsonObject1=jsonArray.getJSONObject(1);
            Toast.makeText(MainActivity.this,jsonObject1.getString("firstName"), Toast.LENGTH_SHORT).show();
        } catch (JSONException ex) {
            // 异常处理代码
        }
        */
    }

}
