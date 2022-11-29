import React, {useState} from "react";
import Input from "../../components/input"
import Button from "../../components/button"
import * as C from "./style"
import { Link, useNavigate } from "react-router-dom";
import useAuth from "../../hooks/useAuth"

const Signin = ()=>{
    const { signin } = useAuth();
    const navigate = useNavigate();

    const [email,setEmail] = useState("");
    const [senha,setSenha] = useState("");
    const [error,setError] = useState("");

    const handleLogin = ()=>{
        if(!email || !senha){
            setError("Preencha todos os campos!")
        }else{
            navigate("/home")
        }
        
    }

    return (
        <C.Container>
            <C.Label>SISTEMA DE AGENDAMENTOS</C.Label>
            <C.Content>
                <Input
                type="email"
                placeholder="Digite seu email"
                value={email}
                onChange={(e)=> [setEmail(e.target.value),setError(" ")]}
                />
                <Input
                type="password"
                placeholder="Digite sua Senha"
                value={senha}
                onChange={(e)=> [setSenha(e.target.value),setError(" ")]}
                />
                <C.LabelError>{error}</C.LabelError>
                <Button Text="Entrar" onClick={handleLogin}/>

                <C.LabelSignup>
                    Esqueceu a senha?
                    <C.Strong>
                        <Link to="/signup">&nbsp;Recupere sua conta</Link>
                    </C.Strong>
                </C.LabelSignup>
            </C.Content>
        </C.Container>
    )
}

export default Signin;