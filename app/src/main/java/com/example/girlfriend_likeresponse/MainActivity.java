package com.example.girlfriend_likeresponse;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private LinearLayout messageContainer;
    private EditText userInput;
    private Button sendButton;
    private NestedScrollView scrollView;

    private final String[] supportiveResponses = {
            "You're doing amazing, keep it up! 💪",
            "Don't stress, I'm here to help you study. 📝",
            "Want me to quiz you? Let's prep together!",
            "Remember, you’re smarter than you think!",
            "One step at a time. You’ve got this! ✅",
            "Just revise a little each day, we’ll ace it together!",
            "I'll help you stay on track. No worries. 😎"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageContainer = findViewById(R.id.messageContainer);
        userInput = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.sendButton);
        scrollView = findViewById(R.id.scrollView);

        addMessage("📚 StudyBot: Hello! Need help with assignments or quiz prep today?", false);

        sendButton.setOnClickListener(v -> sendMessage());

        userInput.setOnEditorActionListener((v, actionId, event) -> {
            sendMessage();
            return true;
        });
    }

    private void sendMessage() {
        String message = userInput.getText().toString().trim();
        if (!message.isEmpty()) {
            addMessage("You: " + message, true);
            userInput.setText("");

            new Handler().postDelayed(() -> {
                String response = generateUniHelperResponse(message);
                addMessage("📚 StudyBot: " + response, false);
            }, 1000);
        }
    }

    private void addMessage(String text, boolean isUser) {
        TextView messageView = new TextView(this);
        messageView.setText(text);
        messageView.setTextSize(16);
        messageView.setPadding(16, 12, 16, 12);
        messageView.setTextColor(getResources().getColor(android.R.color.black));
        messageView.setBackgroundResource(isUser ? R.drawable.bg_user_message : R.drawable.bg_bot_message);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 10, 0, 10);
        params.gravity = isUser ? Gravity.END : Gravity.START;

        messageView.setLayoutParams(params);
        messageContainer.addView(messageView);

        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }

    private String generateUniHelperResponse(String message) {
        message = message.toLowerCase();

        if (message.contains("assignment") && message.contains("due")) {
            return "Your assignment is due this Friday. Want to begin now?";
        } else if (message.contains("assignment") && message.contains("start")) {
            return "Start by reviewing the instructions. I can help outline the structure.";
        } else if (message.contains("assignment") && message.contains("idea")) {
            return "Let's brainstorm together! What's the topic?";
        } else if (message.contains("assignment")) {
            return "Need help with planning or writing your assignment? I’m here to assist.";
        } else if (message.contains("quiz") && message.contains("tomorrow")) {
            return "No worries! Let’s revise key topics and past questions together.";
        } else if (
                (message.contains("quiz") && message.contains("topic")) ||
                        (message.contains("quiz") && message.contains("topics")) ||
                        (message.contains("quiz") && message.contains("cover")) ||
                        (message.contains("quiz") && message.contains("included")) ||
                        message.contains("which topic") ||
                        message.contains("what topic") ||
                        message.contains("topics covered") ||
                        message.contains("covered in quiz")
        ) {
            return "Lectures 3 and 4 are often important. Want a quick recap? 📘";
        } else if (
                (message.contains("quiz") && message.contains("tip")) ||
                        (message.contains("mcq") && message.contains("tip")) ||
                        (message.contains("tips for mcq"))
        ) {
            return "Tip: Eliminate obviously wrong answers first in MCQs.";
        } else if (
                (message.contains("quiz") && message.contains("revise")) ||
                        (message.contains("revise for")) ||
                        (message.contains("revise 20"))
        ) {
            return "Let’s do a 20-minute revision sprint.";
        } else if (message.contains("quiz") && message.contains("prepare")) {
            return "Start with short summaries. I’ll quiz you after that.";
        } else if (message.contains("quiz") || message.contains("mcqs")) {
            return "Eliminate obviously wrong answers first in MCQs.";
        } else if (message.contains("exam") || message.contains("paper")) {
            return "Let's build a simple study plan. Which subject should we focus on first?";
        } else if (message.contains("deadline")) {
            return "You have a quiz on Monday and an assignment on Friday. Want reminders?";
        } else if (message.contains("study") || message.contains("prepare")) {
            return "How about a Pomodoro session? 25 minutes study, 5 minutes break. Ready?";
        } else if (message.contains("thank")) {
            return "You're welcome! Let’s keep going strong.";
        } else if (message.contains("focus") || message.contains("concentrate")) {
            return "Let’s eliminate distractions and tackle one task at a time.";
        } else if (message.contains("tired") || message.contains("stressed")) {
            return "Let’s take a 5-minute break. Then we’ll ease back into studying.";
        } else if (message.contains("bye") || message.contains("later")) {
            return "Okay, take care! I’ll be here when you're ready to study again. 📖";
        } else {
            return supportiveResponses[new Random().nextInt(supportiveResponses.length)];
        }
    }
}
