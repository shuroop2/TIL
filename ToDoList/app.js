// Selectors
const todoInput = document.querySelector('.todo_input')
const todoButton = document.querySelector('.todo_button')
const todoList = document.querySelector('.todo_list')
const filterOption = document.querySelector('.filter_todo')

// Event Listeners
document.addEventListener('DOMContentLoaded', getTodos);
todoButton.addEventListener('click', addTodo);
todoList.addEventListener('click', deleteCheck);
filterOption.addEventListener('click', filterTodo);

// Functions

function addTodo(event) {
    // Prevent form from submitting
    event.preventDefault();
    // BLANK CHECK
    if (todoInput.value == "") {
        alert('내용을 입력하세요');
        return;
    }
    // Todo div
    const todoDiv = document.createElement("div");
    todoDiv.classList.add("todo");
    // Create LI
    const newTodo = document.createElement('li');
    newTodo.innerText = todoInput.value;
    newTodo.classList.add('todo_item');
    todoDiv.appendChild(newTodo);
    // ADD TODO TO LOCALSTORAGE
    saveLocalTodos(todoInput.value);
    // CHECK MARK BUTTON
    const completedButton = document.createElement('button');
    completedButton.innerHTML = '<i class="fas fa-check"></i>';
    completedButton.classList.add("complete_btn");
    todoDiv.appendChild(completedButton);
    // CHECK trash BUTTON
    const trashButton = document.createElement('button');
    trashButton.innerHTML = '<i class="fas fa-trash"></i>';
    trashButton.classList.add("trash_btn");
    todoDiv.appendChild(trashButton);
    // APPEND TO LIST
    todoList.appendChild(todoDiv);
    // Clear Todo INPUT VALUE
    todoInput.value = "";
}

function deleteCheck(event) {
    const item = event.target;
    // DELETE
    if (item.classList[0] === 'trash_btn') {
        const todo = item.parentElement;
        // Animation
        todo.classList.add("fall");
        removeLocalTodos(todo);
        todo.addEventListener('transitionend', function () {
            todo.remove();
        });
    }

    // CHECK MARK
    if (item.classList[0] === "complete_btn") {
        const todo = item.parentElement;
        todo.classList.toggle("completed");
    }
}

function filterTodo(event) {
    const todos = todoList.childNodes;
    todos.forEach(function (todo) {
        switch (event.target.value) {
            case "all":
                todo.style.display = "flex";
                break;
            case "completed":
                if (todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
            case "uncompleted":
                if (!todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
        }
    });
}

function saveLocalTodos(todo) {
    // CHECK -- Hey Do i already have thing in there?
    let todos;
    if (localStorage.getItem('todos') === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem('todos'));
    }

    todos.push(todo);
    localStorage.setItem('todos', JSON.stringify(todos));
}

function getTodos() {
    // CHECK -- Hey Do i already have thing in there?
    let todos;
    if (localStorage.getItem('todos') === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem('todos'));
    }
    todos.forEach(function (todo) {
        // Todo div
        const todoDiv = document.createElement("div");
        todoDiv.classList.add("todo");
        // Create LI
        const newTodo = document.createElement('li');
        newTodo.innerText = todo;
        newTodo.classList.add('todo_item');
        todoDiv.appendChild(newTodo);

        // CHECK MARK BUTTON
        const completedButton = document.createElement('button');
        completedButton.innerHTML = '<i class="fas fa-check"></i>';
        completedButton.classList.add("complete_btn");
        todoDiv.appendChild(completedButton);
        // CHECK trash BUTTON
        const trashButton = document.createElement('button');
        trashButton.innerHTML = '<i class="fas fa-trash"></i>';
        trashButton.classList.add("trash_btn");
        todoDiv.appendChild(trashButton);
        // APPEND TO LIST
        todoList.appendChild(todoDiv);
    });
}

function removeLocalTodos(todo) {
    // CHECK -- Hey Do i already have thing in there?
    let todos;
    if (localStorage.getItem('todos') === null) {
        todos = [];
    } else {
        todos = JSON.parse(localStorage.getItem('todos'));
    }
    const todoIndex = todo.children[0].innerText;
    todos.splice(todos.indexOf(todoIndex), 1);
    localStorage.setItem('todos', JSON.stringify(todos));
}