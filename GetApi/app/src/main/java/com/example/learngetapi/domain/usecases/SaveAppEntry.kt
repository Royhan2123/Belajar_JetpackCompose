package com.example.learngetapi.domain.usecases

import com.example.learngetapi.domain.manger.LocalUserManger

class SaveAppEntry (
    private val localUserManger : LocalUserManger
) {
    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}