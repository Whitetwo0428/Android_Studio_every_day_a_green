package com.example.mid_project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        taskList = new ArrayList<>();
        taskList.add(new Task("任務1", "這是第一個任務"));
        taskList.add(new Task("任務2", "這是第二個任務"));
        taskList.add(new Task("任務3", "這是第三個任務"));

        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);
    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
        private List<Task> taskList;

        public TaskAdapter(List<Task> taskList) {
            this.taskList = taskList;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);
            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            Task task = taskList.get(position);
            holder.titleTextView.setText(task.getTitle());
            holder.descriptionTextView.setText(task.getDescription());
            holder.completedCheckBox.setChecked(task.isCompleted());

            // 設置CheckBox的點擊監聽器
            holder.completedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    task.setCompleted(isChecked); // 更新任務完成狀態
                }
            });
        }

        @Override
        public int getItemCount() {
            return taskList.size();
        }

        class TaskViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            TextView descriptionTextView;
            CheckBox completedCheckBox;

            public TaskViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
                completedCheckBox = itemView.findViewById(R.id.completedCheckBox);
            }
        }
    }


    public class Task {
        private String title;
        private String description;
        private boolean completed; // 新增一個用於跟踪任務完成狀態的屬性

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false; // 初始狀態為未完成
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
}


