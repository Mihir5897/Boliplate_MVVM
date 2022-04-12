package com.me.boliplate_mvvm.view.base;



public interface BaseListener {

    /**
     * Method to show a progress dialog on some background task
     */
    void showHideProgressDialog(boolean iShow);

    /**
     * Method to show a progress bar on some background task
     */
    void showHideProgressBar(boolean iShow);


}


