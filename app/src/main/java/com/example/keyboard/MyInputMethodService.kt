package com.example.keyboard

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo


class MyInputMethodService : InputMethodService() {

    override fun onCreateInputView(): View {
        return layoutInflater.inflate(R.layout.my_keyboard, null).apply {
            if (this is KeyboardView) {
                setOnKeyboardActionListener(MyOnKeyboardActionListener())
                val keyboard = Keyboard(this@MyInputMethodService, R.xml.key_definition_ru)
                setKeyboard(keyboard)
            }
        }
//        return ComposeView(this).apply {
//            setContent {
//                Text(text = "A")
//            }
//        }
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyLongPress(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyLongPress(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyMultiple(keyCode: Int, count: Int, event: KeyEvent?): Boolean {
        return super.onKeyMultiple(keyCode, count, event)
    }

    private inner class MyOnKeyboardActionListener : KeyboardView.OnKeyboardActionListener {

        override fun onPress(primaryCode: Int) = Unit

        override fun onRelease(primaryCode: Int) = Unit

        override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
            val text =primaryCode.toChar().toString()
            val inputConnection = currentInputConnection
            inputConnection.commitText(text, 1)
        }

        override fun onText(text: CharSequence?) = Unit

        override fun swipeLeft() = Unit

        override fun swipeRight() = Unit

        override fun swipeDown() = Unit

        override fun swipeUp() = Unit
    }
}
