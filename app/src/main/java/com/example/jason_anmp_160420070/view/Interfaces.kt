package com.example.jason_anmp_160420070.view

import android.view.View

interface UserActions {
    fun onLoginClick(v: View)
    fun onRegisterClick(v: View)
}

interface NewsDetailsActions {
    fun onBackClick(v: View)
    fun onForwardClick(v: View)
    fun onBackToListClick(v: View)
}

interface NewsItemActions {
    fun onDetailsClick(v: View)
}

interface UserRegistrationActions {
    fun onRegisterClick(v: View)
}

interface UserDetailActions {
    fun onUpdateClick(v: View)
    fun onLogoutClick(v: View)
}