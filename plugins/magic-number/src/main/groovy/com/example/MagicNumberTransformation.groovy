package com.example

import groovy.transform.CompileStatic
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.stmt.ReturnStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

import java.lang.reflect.Modifier

@CompileStatic
@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class MagicNumberTransformation implements ASTTransformation {

    @Override
    void visit(ASTNode[] nodes, SourceUnit source) {
        ClassNode annotatedClassNode = (ClassNode) nodes[1]

        def existingMethod = annotatedClassNode.getMethod(
                'getMagicNumber',
                new Parameter[0]
        )

        if (!existingMethod) {
            def returnStatement = new ReturnStatement(
                    new ConstantExpression(42)
            )
            def newMethod = new MethodNode(
                    'getMagicNumber',
                    Modifier.PUBLIC,
                    ClassHelper.make(Integer),
                    new Parameter[0],
                    null,
                    returnStatement
            )
            annotatedClassNode.addMethod newMethod
        }
    }
}
