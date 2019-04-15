package com.dalton.collegeapp_dalton;

import android.app.Fragment;

public class DatePickerFragment extends DialogFragment{
    final static String DATE_ARGUMENT ="dateofbirth";
    final static String EXTRA_DATE_OF_BIRTH = "com.linburgtech.collegeapp_linburg2019.DatePickerFragment";
    DatePicker mDatePicker;
    Date mDate;
    Calendar mCalendar;

    @Override
    public AlertDialog onCreateDialog(Bundle bundle){
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_date_picker, null);
        mDate = (Date)getArguments().getSerializable(DATE_ARGUMENT);
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(mDate);
        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_of_birth);
        mDatePicker.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH), null);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Date of Birth")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Date date = new GregorianCalendar(mDatePicker.getYear(), mDatePicker.getMonth(), mDatePicker.getDayOfMonth()).getTime();

                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();
    }

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(DATE_ARGUMENT, date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void sendResult(int resultCode, Date date){
        if (getTargetFragment() != null){
            Intent intent = new Intent();
            intent.putExtra(EXTRA_DATE_OF_BIRTH, date);
            Log.i("DatePickerFragment", date.toString());
            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
        }
    }

}
