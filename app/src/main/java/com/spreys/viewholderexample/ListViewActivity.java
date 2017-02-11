package com.spreys.viewholderexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.spreys.viewholderexample.Model.Contact;
import com.spreys.viewholderexample.Model.MockDataGenerator;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ContactsAdapter(this));
    }

    class ContactsAdapter extends ArrayAdapter<Contact>{
        private List<Contact> contacts;

        public ContactsAdapter(Context context) {
            super(context, -1);
            this.contacts = MockDataGenerator.getMockContacts(1000);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
            }

            Contact contact = contacts.get(position);
            ((TextView)convertView.findViewById(R.id.name_text_view)).setText(contact.getName());
            ((TextView)convertView.findViewById(R.id.mobile_text_view)).setText(contact.getMobile());
            ((TextView)convertView.findViewById(R.id.landline_text_view)).setText(contact.getLandline());

            return convertView;
        }

        @Override
        public int getCount() {
            return this.contacts.size();
        }
    }
}
