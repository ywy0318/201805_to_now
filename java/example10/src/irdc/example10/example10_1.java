package irdc.example10;

/* import���class */
import irdc.example10.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class example10_1 extends ListActivity
{
  /* �������� */
  private TextView mText;
  private String title="";
  private List<News> li=new ArrayList<News>();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /* ����layoutΪnewslist.xml */
    setContentView(R.layout.newslist);

    mText=(TextView) findViewById(R.id.myText);
    /* ȡ��Intent�е�Bundle���� */
    Intent intent=this.getIntent();
    Bundle bunde = intent.getExtras();
    /* ȡ��Bundle�����е����� */
    String path = bunde.getString("path");
    /* ����getRss()ȡ�ý������List */
    li=getRss(path);
    mText.setText(title);
    /* �����Զ����MyAdapter */
    setListAdapter(new MyAdapter(this,li));
  }

  /* ����ListItem�����ʱҪ���Ķ��� */
  @Override
  protected void onListItemClick(ListView l,View v,int position,
                                 long id)
  {
    /* ȡ��News���� */
    News ns=(News)li.get(position);
    /* newһ��Intent���󣬲�ָ��class */
    Intent intent = new Intent();
    intent.setClass(example10_1.this,example10_2.class);
    /* newһ��Bundle���󣬲���Ҫ���ݵ����ݴ��� */
    Bundle bundle = new Bundle();
    bundle.putString("title",ns.getTitle());
    bundle.putString("desc",ns.getDesc());
    bundle.putString("link",ns.getLink());
    /* ��Bundle����assign��Intent */
    intent.putExtras(bundle);
    /* ����Activity EX08_13_2 */
    startActivity(intent);
  }

  /* ����XML�ķ��� */
  private List<News> getRss(String path)
  {
    List<News> data=new ArrayList<News>();
    URL url = null;
    try
    {  
      url = new URL(path);
      /* ����SAXParser���� */ 
      SAXParserFactory spf = SAXParserFactory.newInstance();
      SAXParser sp = spf.newSAXParser(); 
      /* ����XMLReader���� */ 
      XMLReader xr = sp.getXMLReader(); 
      /* �����Զ����MyHandler��XMLReader */ 
      MyHandler myExampleHandler = new MyHandler(); 
      xr.setContentHandler(myExampleHandler);
      /* ����XML */
      xr.parse(new InputSource(url.openStream()));
      /* ȡ��RSS�����������б� */
      data =myExampleHandler.getParsedData(); 
      title=myExampleHandler.getRssTitle();
    }
    catch (Exception e)
    {
      /* ��������ʱ����result����һ��activity */
      Intent intent=new Intent();
      Bundle bundle = new Bundle();
      bundle.putString("error",""+e);
      intent.putExtras(bundle);
      /* ����ķ���ֵ����Ϊ99 */
      example10_1.this.setResult(99, intent);
      example10_1.this.finish();
    }
    return data;
  }
}
