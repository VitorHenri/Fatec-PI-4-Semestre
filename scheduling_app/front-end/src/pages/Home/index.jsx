import React from "react";
import Button from "../../components/button";
import * as C from "./style";
import { Link } from "react-router-dom";
import { useState } from "react";
import { useEffect } from "react";

function Registers({list = []}){
    return <table>
        <thead>
            <tr>
                <th>ID Sala</th>
                <th>Bloco</th>
                <th>Número</th>
                <th>Tipo de Sala</th>
                <th>Descrição</th>
            </tr>
        </thead>
        <tbody>
            {
                list.map(({id,bloco,numero,tipo,descricao})=>{
                    return <tr key={id}>
                        <td>{id}</td>
                        <td>{bloco}</td>
                        <td>{numero}</td>
                        <td>{tipo}</td>
                        <td>{descricao}</td>
                    </tr>
                })
            }
        </tbody>
    </table>
}

const Home = ()=>{

    const [list,setList]=useState([])

    useEffect(  ()=>{
        fetch("http://localhost:8080/salas")
        .then( async result =>{
            setList( await result.json())
        })
    },[])
    return(
        <C.Div>
            <C.Aside>
                <Link to="/principal"><Button Text="Salas"/></Link>
                <Link to="/agendar"><Button Text="Agendar"/></Link>
                <Link to="/agendamentos"><Button Text="Verificar Agenedamentos"/></Link>
                <Link to="/"><Button Text="Sair"/></Link>       
            </C.Aside>
            <C.Content>
                <h2>Meus agendamentos</h2>
            <div>
                <Registers list={list}/>
            </div>
            </C.Content>
        </C.Div>
        )

}

export default Home; 