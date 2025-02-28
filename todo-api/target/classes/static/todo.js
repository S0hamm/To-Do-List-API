const API_URL = '/todos'; // Backend API endpoint

document.addEventListener('DOMContentLoaded', () => {
    const taskList = document.getElementById('task-list');
    const taskInput = document.getElementById('task-input');
    const addTaskForm = document.getElementById('add-task-form');

    // Fetch and display tasks
    function fetchTasks() {
        fetch(API_URL)
            .then(response => response.json())
            .then(tasks => {
                taskList.innerHTML = ''; // Clear the task list
                tasks.forEach(task => renderTask(task));
            })
            .catch(err => console.error('Error fetching tasks:', err));
    }

    // Add a new task
    addTaskForm.addEventListener('submit', event => {
        event.preventDefault();
        const newTask = { name: taskInput.value, completed: false };

        fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(newTask)
        })
        .then(response => {
            if (response.ok) {
                taskInput.value = ''; // Clear the input field
                fetchTasks(); // Refresh the task list
            }
        })
        .catch(err => console.error('Error adding task:', err));
    });

    // Delete a task
    function deleteTask(taskId) {
        fetch(`${API_URL}/${taskId}`, { method: 'DELETE' })
            .then(() => fetchTasks()) // Refresh the task list
            .catch(err => console.error('Error deleting task:', err));
    }

    // Render a task in the list
    function renderTask(task) {
        const taskItem = document.createElement('li');
        taskItem.className = 'list-group-item d-flex justify-content-between align-items-center';
        taskItem.innerHTML = `
            ${task.name}
            <button class="btn btn-danger btn-sm" onclick="deleteTask(${task.id})">Delete</button>
        `;
        taskList.appendChild(taskItem);
    }

    // Initialize the app
    fetchTasks();
});
