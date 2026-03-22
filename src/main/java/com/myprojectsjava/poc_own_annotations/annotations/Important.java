package com.myprojectsjava.poc_own_annotations.annotations;

import java.lang.annotation.*;

/**
 * Analogia simples
 * class → cria objeto
 * interface → define contrato
 * @interface → define metadado
 * public @interface Note
 *
 * @Retention - Até quando essa annotation vai existir
 * Ex: SOURCE	Só existe no código, some na compilação
 *     CLASS	Vai até o .class, mas não em runtime
 *     RUNTIME	Disponível em tempo de execução
 *
 * @Target
 * Onde essa annotation pode ser usada
 * TYPE    Classes
 * METHOD	Métodos
 * FIELD	Atributos
 * PARAMETER	Parâmetros
 * CONSTRUCTOR	Construtores
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Important {
}