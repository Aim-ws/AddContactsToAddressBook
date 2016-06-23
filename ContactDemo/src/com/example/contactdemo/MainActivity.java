package com.example.contactdemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.RawContacts.Data;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			((Button)findViewById(R.id.id_add)).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					addContact();
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	protected void addContact() {
		// TODO Auto-generated method stub
		try {
			ContactBean bean = new ContactBean();
			bean.firstname = "Aim_ws";
			bean.companyName="����΢˹����Ϣ�������޹�˾";
			bean.department="�з���";
			bean.jobTitle="Android����ʦ";
			bean.mobile1="13148372460";
			bean.mobile2="18767165139";
			bean.telphoneNumber="86930571";
			bean.virtulNetNumber1="372460";
			bean.note="����΢˹��";
			
			
			ContentResolver contentResolver = getContentResolver();
			ContentValues values = new ContentValues();
			Uri rowContactUri = contentResolver.insert(RawContacts.CONTENT_URI, values);
			long rawContactId = ContentUris.parseId(rowContactUri);
			
			//��������
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
			values.put(StructuredName.GIVEN_NAME, bean.firstname);
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "�������� : "+bean.firstname);
			
			//�����ֻ���
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
			values.put(Phone.NUMBER, bean.mobile1);
			values.put(Phone.TYPE, Phone.TYPE_MOBILE);
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "�����ֻ���:"+bean.mobile1);
			
			//�����ֻ���
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
			values.put(Phone.NUMBER, bean.mobile2);
			values.put(Phone.TYPE, Phone.TYPE_MOBILE);
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "�����ֻ���:"+bean.mobile2);
			//�����ֻ���
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
			values.put(Phone.NUMBER, bean.telphoneNumber);
			values.put(Phone.TYPE, Phone.TYPE_MOBILE);
			values.put(Phone.DATA2, "0");
			values.put(Phone.LABEL, "�绰����");
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "�����ֻ���:"+bean.telphoneNumber);
			//�����ֻ���
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
			values.put(Phone.NUMBER, bean.virtulNetNumber1);
			values.put(Phone.TYPE, Phone.TYPE_MOBILE);
			values.put(Phone.DATA2, "0");
			values.put(Phone.LABEL, "������");
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "�����ֻ���:"+bean.virtulNetNumber1);
			
			//���뱸ע
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Note.CONTENT_ITEM_TYPE);
			values.put(Note.NOTE, bean.note);
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "���뱸ע:"+bean.note);
			
			//���� ��˾  ���� ְλ
			values.clear();
			values.put(Data.RAW_CONTACT_ID, rawContactId);
			values.put(Data.MIMETYPE, Organization.CONTENT_ITEM_TYPE);
			values.put(Organization.COMPANY, bean.companyName);
			values.put(Organization.DEPARTMENT, bean.department);
			values.put(Organization.TITLE, bean.jobTitle);
			contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);
			Log.i(TAG, "���� ��˾  ���� ְλ:"+bean.companyName + "--"+bean.department + "--"+bean.jobTitle);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
