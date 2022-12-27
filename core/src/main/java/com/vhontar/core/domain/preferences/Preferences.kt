package com.vhontar.core.domain.preferences

import com.vhontar.core.domain.models.ActivityLevel
import com.vhontar.core.domain.models.Gender
import com.vhontar.core.domain.models.GoalType
import com.vhontar.core.domain.models.UserInfo

interface Preferences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Int)
    fun saveHeight(height: Int)
    fun saveActivityLevel(level: ActivityLevel)
    fun saveGoalType(type: GoalType)
    fun saveCarbsRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo

    fun saveShouldShowOnboarding(shouldShow: Boolean)
    fun loadShouldShowOnboarding(): Boolean

    companion object {
        const val KEY_GENDER = "key_gender"
        const val KEY_AGE = "key_age"
        const val KEY_WEIGHT = "key_weight"
        const val KEY_HEIGHT = "key_height"
        const val KEY_ACTIVITY_LEVEL = "key_activity_level"
        const val KEY_GOAL_TYPE = "key_goal_type"
        const val KEY_CARB_RATIO = "key_carb_ratio"
        const val KEY_PROTEIN_RATIO = "key_protein_ratio"
        const val KEY_FAT_RATIO = "key_fat_ratio"
        const val KEY_SHOULD_SHOW_ON_BOARDING = "key_should_show_on_boarding"
    }
}