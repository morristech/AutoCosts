package dvinc.autocosts.database;

/**
 * Created by DV on Space 5
 * 28.04.2017
 */

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import dvinc.autocosts.R;

import static dvinc.autocosts.database.Contract.CostEntry.*;

/**
 * TODO
 */
public class HistoryCursorAdapter extends CursorAdapter {

    public HistoryCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * Метод для привязки всех данных к заданному виду, например, для установки текста в TextView.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Находим поля, в которые будем подставлять свои данные в списке
        TextView costTypeTextView = (TextView) view.findViewById(R.id.listCostType);
        TextView dateTextView = (TextView) view.findViewById(R.id.listDate);
        if (cursor != null) {
            // Находим индексы столбцов в курсоре
            int costTypeIndex = cursor.getColumnIndex(COLUMN_COST_TYPE);
            int dateIndex = cursor.getColumnIndex(COLUMN_DATE);

            // Читаем данные из курсора для текущей записи
            String costType = cursor.getString(costTypeIndex);
            String date = cursor.getString(dateIndex);

            // Обновляем текстовые поля, подставляя в них данные для текущей записи
            costTypeTextView.setText(costType);
            dateTextView.setText(date);
        }
    }
    
}
