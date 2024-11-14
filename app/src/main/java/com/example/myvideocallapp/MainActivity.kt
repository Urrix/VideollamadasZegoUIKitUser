package com.example.myvideocallapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton
import com.zegocloud.uikit.service.defines.ZegoUIKitUser
import java.util.Collections

class MainActivity : AppCompatActivity() {

    lateinit var currentUsernameTextView : TextView
    lateinit var targetUsernameImpunt : EditText
    lateinit var voiceCallBtn : ZegoSendCallInvitationButton
    lateinit var videocallBtn : ZegoSendCallInvitationButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        currentUsernameTextView = findViewById(R.id.current_username_textview)
        targetUsernameImpunt = findViewById(R.id.target_usename_input)
        voiceCallBtn = findViewById(R.id.video_call_btn)
        videocallBtn = findViewById(R.id.video_call_btn)

        currentUsernameTextView.text = "Hola " + intent.getStringExtra("username")

        targetUsernameImpunt.addTextChangedListener {
            val targetUsername = targetUsernameImpunt.text.toString()
            setupVoiceCall(targetUsername)
            setupVideoCall(targetUsername)
             }
        }

    fun setupVoiceCall(username : String){
        voiceCallBtn.setIsVideoCall(false)
        voiceCallBtn.resourceID = "zego_uikit_call"
        voiceCallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(username,username)))
        }

    fun setupVideoCall(username : String){
        videocallBtn.setIsVideoCall(true)
        videocallBtn.resourceID = "zego_uikit_call"
        videocallBtn.setInvitees(Collections.singletonList(ZegoUIKitUser(username,username)))
        }
    }

