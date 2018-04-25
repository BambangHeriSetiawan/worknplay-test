package com.simx.worknplaytest.helper;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;


public class DialogHelper {
  public static DialogHelper instance(){
    return new DialogHelper ();
  }
  public AlertDialog showDialogShortChoice(
      Context context,
      DialogInterface.OnClickListener clickListener){
    AlertDialog.Builder builder = new Builder (context);
    ArrayAdapter<String> adapter = new ArrayAdapter<String> (context,android.R.layout.simple_list_item_activated_1);
    adapter.add ("Rating Ascending");
    adapter.add ("Rating Descending");
    builder.setTitle ("Short By : ");
    builder.setAdapter (adapter,clickListener);
    AlertDialog dialog = builder.create ();
    return dialog;
  }
}
