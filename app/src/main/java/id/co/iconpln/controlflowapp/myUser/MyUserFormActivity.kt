package id.co.iconpln.controlflowapp.myUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.models.myUser.UserDataResponse
import kotlinx.android.synthetic.main.activity_my_user_form.*

class MyUserFormActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }

    private lateinit var viewModel: MyUserFormViewModel
    private lateinit var user: UserDataResponse
    private var userId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_user_form)
        initIntentExtra()
        initViewModel()
        populateFormData(user)
    }

    private fun initIntentExtra() {
        user = intent.getParcelableExtra(EXTRA_USER) as UserDataResponse
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MyUserFormViewModel::class.java)
    }

    private fun populateFormData(user: UserDataResponse){
        etUserFormName.setText(user.name)
        etUserFormAddress.setText(user.address)
        etUserFormHp.setText(user.phone)
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnUserFormSave -> {
                userId?.let { id ->
                    val updateUserData = UserDataResponse(
                        etUserFormAddress.text.toString(),
                        id,
                        etUserFormName.text.toString(),
                        etUserFormHp.text.toString()
                    )

                    updateUser(id, updateUserData)
                }
            }
        }
    }

    private fun updateUser(id: Int, userData: UserDataResponse) {

    }


}
