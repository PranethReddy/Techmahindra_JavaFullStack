// Create Routine Page
if (document.getElementById('routine-form')) {
    document.getElementById('routine-form').addEventListener('submit', saveRoutine);
    document.getElementById('duration').addEventListener('input', function() {
        document.getElementById('duration-value').textContent = this.value;
    });
    document.getElementById('rest').addEventListener('input', function() {
        document.getElementById('rest-value').textContent = this.value;
    });
}

function addExercise() {
    const type = document.getElementById('exercise-type').value;
    const duration = document.getElementById('duration').value;
    const rest = document.getElementById('rest').value;
    const li = document.createElement('li');
    li.textContent = `${type} - ${duration} min, ${rest} sec rest`;
    document.getElementById('exercise-list').appendChild(li);
}

function saveRoutine(event) {
    event.preventDefault();
    const name = document.getElementById('routine-name').value;
    const exercises = Array.from(document.getElementById('exercise-list').children)
        .map(li => li.textContent);
    const routine = { name, exercises };
    let routines = JSON.parse(localStorage.getItem('routines')) || [];
    routines.push(routine);
    localStorage.setItem('routines', JSON.stringify(routines));
    alert('Routine saved!');
    document.getElementById('routine-form').reset();
    document.getElementById('exercise-list').innerHTML = '';
}

// My Routines Page
if (document.getElementById('routine-list')) {
    window.onload = loadRoutines;
}

function loadRoutines() {
    const routines = JSON.parse(localStorage.getItem('routines')) || [];
    const container = document.getElementById('routine-list');
    routines.forEach(routine => {
        const div = document.createElement('div');
        div.innerHTML = `<h3>${routine.name}</h3><ul>${routine.exercises.map(ex => `<li>${ex}</li>`).join('')}</ul>`;
        container.appendChild(div);
    });
}

// Progress Tracker Page
if (document.getElementById('progress-form')) {
    document.getElementById('progress-form').addEventListener('submit', logWorkout);
    window.onload = renderChart;
}

function logWorkout(event) {
    event.preventDefault();
    const date = document.getElementById('date').value;
    const routine = document.getElementById('routine-completed').value;
    let progress = JSON.parse(localStorage.getItem('progress')) || [];
    progress.push({ date, routine });
    localStorage.setItem('progress', JSON.stringify(progress));
    document.getElementById('progress-form').reset();
    renderChart();
}

function renderChart() {
    const progress = JSON.parse(localStorage.getItem('progress')) || [];
    const dates = progress.map(p => p.date);
    const ctx = document.getElementById('progress-chart').getContext('2d');
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: dates,
            datasets: [{
                label: 'Workouts Completed',
                data: dates.map(() => 1),
                borderColor: '#3498db',
                fill: false
            }]
        },
        options: {
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
}