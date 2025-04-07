import { useState } from "react";
import AddTask from "./components/AddTask";
import Tasks from "./components/Tasks";
import './index.css';

function App() {
  const [tasks, setTasks] = useState([
    {
      id: 1,
      title: "Estudar programacao",
      description: "Estudar programacao para se tornar um desenvolvedor FullStack",
      isCompleted: false,
    },
    {
      id: 2,
      title: "Fazer compras",
      description: "",
      isCompleted: false,
    },
    {
      id: 3,
      title: "Ler um livro",
      description: "",
      isCompleted: false,
    }

  ]);

  function onTaskClick(taskId) {
    const newTasks = tasks.map(task => {
      if(task.id == taskId){
        return {... task, isCompleted: !task.isCompleted}
      } else {
        return task;
      }
    });
    setTasks(newTasks);
  }

  function onTrashClick(taskId){
    const newTasks = tasks.filter(taks => taks.id != taskId);
    setTasks(newTasks);
  }

  return (
    <div className="w-screen h-screen bg-slate-500 flex justify-center p-6">
     <div className="w-[500px]">
      <h1 className="text-3xl text-slate-100 font-bold text-center">Gerenciador de Tarefas</h1>
     <Tasks tasks = {tasks} onTaskClick={onTaskClick} onTrashClick={onTrashClick}/>
     <AddTask />
     </div>
    </div>
    
  );
}

export default App
